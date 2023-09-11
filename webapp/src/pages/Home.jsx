import React, {useState, useEffect} from 'react';
import ButtonToggle from "./Button";
import {Route, Routes, useNavigate} from 'react-router-dom';

localStorage["type"] = "OTHER"

function Home() {
    return (
        <div>
            <h1>Rate My Place of Worship</h1>
            <h2> Welcome to Rate My Place of Worship <br/> </h2>
              <p>  A website to let you rate the places you visit, <br/>
                and search for the best places of worship near you
            </p>
            <h1 style={{color: "green"}}>Please Select your Place of Worship:</h1>
            <App/>
        </div>

    );
}

const App = () => {
    const [users, setUsers] = useState([])
    const [active, setActive] = useState([]);
    const navigate = useNavigate();

    const fetchUserData = () => {
        fetch("http://localhost:8080/home/")
            .then(response => {
                return response.json()
            })
            .then(data => {
                setUsers(data.types)
            })
    }

    useEffect(() => {
        fetchUserData()
    }, [])

    console.log("types" + users)
    return (
        <div>
            {users.map((m) => (
                <ButtonToggle active={active === m} onClick={() => {
                    setActive(m);
                    localStorage["type"] = m
                    navigate('/search', {replace: true});
                }}>
                    {m}
                </ButtonToggle>
            ))}
        </div>
    );

};


export default Home;

import React, {useEffect, useState} from 'react';
import ButtonToggle from "./Button";
import Button from "./Button";
import {render} from "@testing-library/react";
import {useNavigate} from "react-router-dom";

let type = localStorage["type"]


function Search() {
    type = localStorage["type"]

    return (
        <div>
            <h2>Searching for {type}(s)</h2>

            <FetchData/>
        </div>

    );
}

const FetchData = () => {
    const [places, setPlaces] = useState([])
    const [active, setActive] = useState([]);
    const [distance, setDistance] = useState(10)
    const [location, setLocation] = useState(`RG5 4UF`)
    const navigate = useNavigate();






    const fetchData = () => {
        const url = `http://localhost:8080/home/search?type=${type}&location=${location}&distance=${distance}`
        console.log(encodeURI(url))
        fetch(encodeURI(url))
            .then(response => {
                return response.json()
            })
            .then(data => {
                setPlaces(data.placesOfWorship)
            })
    }

    useEffect(() => {
        fetchData()
    }, [location, distance])

    console.log("types" + places)
    return (
        <div>
            <label>Enter location: (PostCode)   <input defaultValue={location}
                                          onChange={e =>
                                              setLocation(e.target.value)}/>
            </label>
            <br/>
            <label htmlFor="radius">Distance (KM):
                <input type="number" id="radius" name="radius" defaultValue={distance}
                       onChange={e =>
                           setDistance(e.target.value)
                       }

                />
            </label>
            <p>
                {places && places.map((m) => (
                    <ButtonToggle key={m.id} active={active === m} onClick={() => {
                        setActive(m)
                        localStorage["id"] = m.id.toString()
                        localStorage["name"] = m.name
                        navigate('/pow', {replace: true});
                    }}>
                        <div>
                            <h2>{m.name}</h2>
                        </div>
                        Address: {m.location.address}
                        <br/>
                        PostCode: {m.location.postcode}
                    </ButtonToggle>
                ))}
            </p>

        </div>
    );

};

export default Search;

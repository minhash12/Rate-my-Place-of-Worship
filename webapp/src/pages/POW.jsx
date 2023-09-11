import React, {useEffect, useState} from 'react';
import {useNavigate} from "react-router-dom";
import Button from "./Button";


function PlaceOfWorship() {
    return (
        <div>
            <h2>Place of Worship: {localStorage["name"]}</h2>
            <Details/>
            <Rating/>
            <Comments/>
            <SubmitRating/>
        </div>

    );
}

const Rating = () => {
    const [ratings, setRatings] = useState([])


    const fetchUserData = () => {
        const id = localStorage["id"].toString()
        console.log(id)
        const url = 'http://localhost:8080/place-of-worship/' + id + '/ratings'
        console.log(encodeURI(url))
        fetch(url)
            .then(response => {
                return response.json()
            })
            .then(data => {
                setRatings(data)
            })
    }

    useEffect(() => {
        fetchUserData()
    }, [])

    console.log("rating" + ratings)
    return (
        <div>
            {Object.entries(ratings).map(([key, value]) => (
                <div key={key}>
                    <strong>{key}:</strong> {value}
                </div>
            ))}
        </div>
    );

};

const Details = () => {
    const [details, setDetails] = useState([])


    const fetchUserData = () => {
        const id = localStorage["id"].toString()
        console.log(id)
        const url = 'http://localhost:8080/place-of-worship/' + id + '/details'
        console.log(encodeURI(url))
        fetch(url)
            .then(response => {
                return response.json()
            })
            .then(data => {
                setDetails(data)
            })
    }

    useEffect(() => {
        fetchUserData()
    }, [])

    console.log("details" + details)
    const dataMap = new Map(Object.entries(details));

    console.log("values" + dataMap.size)
    return (

        <div>
            <p>
                Website: {dataMap.get("website")}</p>

             {/*TODO - add location*/}
        </div>
    );

};

const Comments = () => {
    const [comments, setComments] = useState([])

    const fetchUserData = () => {
        const id = localStorage["id"].toString()
        console.log(id)
        const url = 'http://localhost:8080/place-of-worship/' + id + '/comments'
        console.log(encodeURI(url))
        fetch(url)
            .then(response => {
                return response.json()
            })
            .then(data => {
                setComments(data.comments)
            })
    }

    useEffect(() => {
        fetchUserData()
    }, [])

    console.log("comments" + comments)
    return (
        <div>
                <ul>
                {
                    comments.map((m) => {

                        <li>{m}</li>
                    })
                }
                </ul>



        </div>
    );

};

const SubmitRating = () => {
    const navigate = useNavigate();

    return (
        <div>
            <Button onClick={
                () => {
                    navigate('/rating', {replace: true});
                }
            }>Submit A rating</Button>
        </div>
    )
}

export default PlaceOfWorship;

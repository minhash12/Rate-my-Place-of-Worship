import React, {useCallback} from "react";
import { Model } from "survey-core";
import { Survey } from "survey-react-ui";
import "survey-core/defaultV2.min.css";
import "../index.css";
import { json } from "./json";
import { themeJson } from "./theme";
import {useNavigate} from "react-router-dom";

function SurveyComponent() {
    const survey = new Model(json);
    // You can delete the line below if you do not use a customized theme
    survey.applyTheme(themeJson);

    const navigate = useNavigate();
    const surveyComplete = useCallback((sender) => {
        saveSurveyResults(
            sender.data
        )
        navigate('/', {replace: true});
    }, []);

    survey.onComplete.add(surveyComplete);



    return (<Survey model={survey} />);
}

function saveSurveyResults(json) {
    const url = 'http://localhost:8080/place-of-worship/rating/submit'
    console.log("stringify " + JSON.stringify(json))
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify(json)
    })
        .then(response => {
            if (response.ok) {
                // Handle success
                console.log(response)
            } else {
                // Handle error
            }
        })

}



export default SurveyComponent;


import SurveyComponent from "./SurveyComponent";

function Rating() {
    return (
        <div>
            <h2> Please submit your rating for {localStorage["name"]} with id: {localStorage["id"]}</h2>
            <SurveyComponent/>
            <p>Legal Disclaimer</p>
        </div>

    );
}


export default Rating;

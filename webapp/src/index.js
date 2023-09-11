import ReactDOM from "react-dom";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Search from "./pages/Search";
import PlaceOfWorship from "./pages/POW";
import Rating from "./pages/Rating";
import NoPage from "./pages/NoPage";
import reportWebVitals from "./reportWebVitals";

export default function App() {
    return (
        <BrowserRouter> <Routes>
            <Route path="/" element={<Layout/>}>
                <Route index element={<Home/>}/>
                <Route path="search" element={<Search/>}/>
                <Route path="pow" element={<PlaceOfWorship/>}/>
                <Route path="rating" element={<Rating/>}/>
                <Route path="*" element={
                    <NoPage/>}/>
            </Route> </Routes> </BrowserRouter>);
}
ReactDOM.render(<App/>, document.getElementById("root"));

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals(console.log);

import React from "react";
import {BrowserRouter, Route, Link} from "react-router-dom";

function Navbar() {
    return (<nav>
        <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/search">Search</Link></li>
            <li><Link to="/pow">Place Of Worship</Link></li>
            <li><Link to="/rating">Rating</Link></li>
        </ul>
    </nav>);
}

export default Navbar;

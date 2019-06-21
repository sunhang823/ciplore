import React, { Component } from "react";
import PropertyItem from "./Property/PropertyItem";
import Header from "../Layout/Header";

class PropertyDashboard extends Component {
  render() {
    return (
      <div>
        <Header />
        <h1>Welcome to Property Dashboard</h1>
        <PropertyItem />
      </div>
    );
  }
}

export default PropertyDashboard;

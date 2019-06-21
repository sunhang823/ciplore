import React, { Component } from "react";
import PropertyItem from "./Property/PropertyItem";

class PropertyDashboard extends Component {
  render() {
    return (
      <div>
        <h1>Welcome to Property Dashboard</h1>
        <PropertyItem />
      </div>
    );
  }
}

export default PropertyDashboard;

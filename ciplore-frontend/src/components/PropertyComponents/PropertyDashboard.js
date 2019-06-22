import React, { Component } from "react";
import PropertyItem from "./Property/PropertyItem";

class PropertyDashboard extends Component {
  render() {
    return (
      <div>
        <div className="projects">
          <div className="container">
            <div className="row">
              <div className="col-md-12">
                <h1 className="display-4 text-center">Apartments</h1>
                <hr />
                <PropertyItem />
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default PropertyDashboard;

import React from "react";
import "./App.css";
import PropertyDashboard from "./components/PropertyComponents/PropertyDashboard";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/Layout/Header";

function App() {
  return (
    <div className="App">
      <Header />
      <PropertyDashboard />
    </div>
  );
}

export default App;

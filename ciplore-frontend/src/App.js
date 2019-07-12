import React from "react";
import "./App.css";
import PropertyDashboard from "./components/PropertyComponents/PropertyDashboard";
import "bootstrap/dist/css/bootstrap.min.css";
import Header from "./components/Layout/Header";
import Footer from "./components/Layout/Footer";

function App() {
  return (
    <div className="App">
      <Header />
      <PropertyDashboard />
      <Footer />
    </div>
  );
}

export default App;

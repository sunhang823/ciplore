import React, { Component } from "react";

class Footer extends Component {
  render() {
    return (
      <footer className="footer bg-primary">
        <div className="container">
          <div className="row justify-content-center">
            <div className="col-auto">
              <h5>Links</h5>
            </div>
            <div className="col-auto">
              <ul className="list-unstyled">
                <li>
                  <a
                    href="http://hangsun.site"
                    target="_blank"
                    rel="noopener noreferrer"
                    className="link"
                  >
                    Developer's Homepage
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <div className="row justify-content-center">
            <div className="col-auto">
              <p>© Copyright 2019 Hang Sun</p>
            </div>
          </div>
        </div>
      </footer>
    );
  }
}
export default Footer;

import React from 'react';

class Employee extends React.Component{

  constructor(props) {
    super(props);

    this.state = {
      firstName: "Michal"
    }
  }

  updateEmployee(){
      this.setState({
        firstName: "Mela"
      })
    }

  render() {
    return (
      <div>
        <h1>Employee Details</h1>
        <p>{this.state.firstName}</p>
        <button onClick={() => this.updateEmployee()}>Update Employee</button>
      </div>
    )
  }
}

export default Employee;

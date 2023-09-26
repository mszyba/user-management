import React, {useEffect, useState} from 'react'
import { listEmployees } from '../services/EmployeeService';

const ListEmployeeComponent = () => {

const [employee, setEmployees] = useState([]);

useEffect(() => {
  listEmployees().then((response) => {
    setEmployees(response.data);
  }).catch(error => {
    console.error(error);
  })
}, [])

  return (
    <div className='container'>
        <h1 className='text-center'>List Employee Table</h1>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email ID</th>
                </tr>
            </thead>
            <tbody>
              {
                employee.map(employee => 
                  <tr key={employee.id}>
                    <td>{employee.id}</td>
                    <td>{employee.firstName}</td>
                    <td>{employee.lastName}</td>
                    <td>{employee.email}</td>
                  </tr> )
              }
            </tbody>
        </table>

    </div>
  )
}

export default ListEmployeeComponent
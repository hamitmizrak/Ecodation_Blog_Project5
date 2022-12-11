import React, { Component } from 'react'
import RegisterApiServices from '../../services/RegisterApiServices';

export default class ListRegister extends Component {
    constructor(props) {
        super(props);

        //state
        this.state = {
            registerlist: []
        }

        //bind
    } //end constructor

    //cdm ==>TAB
    //1-) Constructor
    //2-) Render
    //3-) CDM
    componentDidMount() {
        RegisterApiServices.getAllRegister().then(
            (response) => {
                this.setState({
                    registerlist: response.data
                })
            }
        )

    }

    // id;
    // username;
    // email;
    // passwd;

    // render
    render() {
        return (
            <>
                <h1 className="text-center text-uppercase">Register</h1>

                <div className="row">
                    <div className="mx-auto"><button className="btn btn-primary">EKLE</button></div>
                    <table className="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>USERNAME</th>
                                <th>EMAIL</th>
                                <th>PASSWORD</th>
                                <th>UPDATE</th>
                                <th>VIEW</th>
                                <th>DELETE</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.registerlist.map(registerlist =>
                                    <tr key={registerlist.id}>
                                        <td>{registerlist.id}</td>
                                        <td>{registerlist.username}</td>
                                        <td>{registerlist.email}</td>
                                        <td>{registerlist.passwd}</td>
                                        <td><button><i className="fa-solid fa-pen-to-square text-primary"></i></button></td>
                                        <td><button><i className="fa-solid fa-mountain-sun text-success"></i></button></td>
                                        <td><button><i className="fa-solid fa-trash text-danger"></i></button></td>
                                    </tr>
                                )
                            }

                        </tbody>
                    </table>

                </div>

            </>
        )
    }
}

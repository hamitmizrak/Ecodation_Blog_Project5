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
        this.addRegister = this.addRegister.bind(this);
        this.updateRegister = this.updateRegister.bind(this);
        this.viewRegister = this.viewRegister.bind(this);
        this.deleteRegister = this.deleteRegister.bind(this);

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

    //Function start
    //ADD
    addRegister() {
        this.props.history.push("/register-update/")
    }


    //UPDATE
    updateRegister(id) {
        this.props.history.push(`/register-update/${id}`)
    }

    //VIEW
    viewRegister(id) {
        this.props.history.push(`/register-view/${id}`)
    }

    //DELETE
    deleteRegister(id) {
        RegisterApiServices.deleteRegister(id).then(
            response => {
                this.setState({
                    registerlist: this.state.registerlist.filter(
                        registerlist => registerlist.id != id
                    )
                })
            }
        );
    }


    //Function ends


    // render
    render() {
        return (
            <>
                <h1 className="text-center text-uppercase">Register</h1>
                <div className="row">
                    <div className="mx-auto">
                        <button className="btn btn-primary" onClick={this.addRegister}>EKLE</button>
                    </div>
                    <table className="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>USERNAME</th>
                                <th>EMAIL</th>
                                <th>PASSWORD</th>
                                <th>DATE</th>
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
                                        <td>{registerlist.createdDate}</td>
                                        <td>
                                            <i className="fa-solid fa-pen-to-square text-primary" onClick={() => this.updateRegister(registerlist.id)}></i>

                                        </td>
                                        <td>
                                            <i className="fa-solid fa-mountain-sun text-success" onClick={() => this.viewRegister(registerlist.id)}></i>
                                        </td>
                                        <td>
                                            <i className="fa-solid fa-trash text-danger" onClick={() => {
                                                if (window.confirm("Are you sure you delete this ?"))
                                                    this.deleteRegister(registerlist.id)
                                            }}></i>
                                        </td>
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

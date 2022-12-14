import React, { Component } from 'react'
import RegisterApiServices from '../../services/RegisterApiServices';

// Dil secenegi
import { withTranslation } from 'react-i18next';

class ListRegister extends Component {
    constructor(props) {
        super(props);
        //state
        this.state = {
            registerlist: []
        }
        //bind
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
    // Function start

    // UPDATE & ADD 
    // EKLEME ==> http://localhost:3000/register-add/undefined 
    // GÜNCELLEME ==> http://localhost:3000/register-add/1


    addRegister(id) {
        this.props.history.push(`/register_add/create`)
    }


    updateRegister(id) {
        this.props.history.push(`/register_add/${id}`)
    }

    //VIEW
    viewRegister(id) {
        this.props.history.push(`/register_view/${id}`)
    }

    //DELETE
    deleteRegister(id) {
        RegisterApiServices.deleteRegister(id).then(
            response => {
                this.setState({
                    registerlist: this.state.registerlist.filter(
                        registerlist => registerlist.id !== id
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
                <h1 className="text-center text-uppercase">{this.props.t('register')}</h1>
                <div className="row">
                    <div className="mx-auto">
                        <button className="btn btn-primary" onClick={()=>this.addRegister()}>{this.props.t('registerAdd')}</button>
                    </div>
                    <table className="table table-hover table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>{this.props.t('username')}</th>
                                <th>{this.props.t('email')}</th>
                                <th>{this.props.t('password')}</th>
                                <th>{this.props.t('date')}</th>
                                <th>{this.props.t('update')}</th>
                                <th>{this.props.t('view')}</th>
                                <th>{this.props.t('delete')}</th>
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
                                        <td> <i className="fa-solid fa-pen-to-square text-primary" onClick={() => this.updateRegister(registerlist.id)}></i>
                                        </td>
                                        <td> <i className="fa-solid fa-mountain-sun text-success" onClick={() => this.viewRegister(registerlist.id)}></i>  </td>
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



// export default 
//  Higher Order Component: monad componenti başka bir componentin içine  ekleyip oradanda yeni sonuclar elde etmek
export default withTranslation()(ListRegister)
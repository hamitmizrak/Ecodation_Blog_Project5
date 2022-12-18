import React, { Component } from 'react'
import RegisterApiServices from '../../services/RegisterApiServices';

export default class DetailPageRegister extends Component {
  //constructor
  constructor(props) {
    super(props);

    //state
    this.state = {
      id: this.props.match.params.id,
      registerDto: {} //içi boş 
    }
    //bind
  }  //end constructor

  //cdm ==>TAB
  //1-) Constructor
  //2-) Render
  //3-) CDM

  //CDM
  componentDidMount() {
    RegisterApiServices.getRegisterById(this.state.id).then(
      response => this.setState({
        registerDto: response.data
      })
    );
  }

  //functiron start
  //functiond end

  //render
  render() {
    return (
      <>
      <div className="container">
        <div className="row">
          <div className="card mt-5 shadow" style={{padding:"1rem"}}>
          <div className="card-body">
            <h4 className="card-title">Register Details Page</h4>
            <p className="card-title"><i className="fa-solid fa-fingerprint"></i>: {this.state.registerDto.id} </p>
            <p className="card-text"><i className="fa-solid fa-user"></i>: {this.state.registerDto.username}</p>
            <p className="card-text"><i className="fa-solid fa-key"></i>: {this.state.registerDto.passwd}</p>
            <p className="card-text"><i className="fa-solid fa-envelope-circle-check"></i>: {this.state.registerDto.email}</p>
            <p className="card-text text-danger ">  <i className="fa-solid fa-clock"></i>: {this.state.registerDto.createdDate}</p>
          </div>
        </div></div>
      </div>
        
      </>
    )
  }
}

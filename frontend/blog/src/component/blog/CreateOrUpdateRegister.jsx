import React, { Component } from 'react'
import RegisterApiServices from '../../services/RegisterApiServices'
import CreateOrUpdateReusability from '../reusability/CreateOrUpdateReusability';

export default class CreateOrUpdateRegister extends Component {

  //constructor
  constructor(props) {
    super(props)

    //state
    this.state = {
      id: this.props.match.params.id,
      username: '',
      email: '',
      passwd: ''
    }

    //bind
    this.titleDynamicsSaveOrUpdate = this.titleDynamicsSaveOrUpdate.bind(this);
    this.homePage = this.homePage.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.saveOrUpdateRegister = this.saveOrUpdateRegister.bind(this);
    this.homePage = this.homePage.bind(this);
    //Form submit ==> aşağıda kodta bağladım
    //this.cancel = this.cancel.bind(this); 
  }

  //CDM 
  componentDidMount() {
    // EKLEME    ==> undefined 
    // GÜNCELLEME ==> 1
    //EKLEME
    if (this.state.id === 'create') {
      return;
      //
    } else {//GÜNCELLEME
      RegisterApiServices.getRegisterById(this.state.id).then(
        response => {
          const registerDto = response.data;
          console.log(registerDto);
          this.setState({
            username: registerDto.username,
            email: registerDto.email,
            passwd: registerDto.passwd
          }) //end state
        } //end response
      )//end then
    } //end else
  } //end componentDidMount

  //function start
  //HOME
  homePage() {
    return this.props.history.push("/")
  }

  //CANCEL
  cancel() {
    return this.props.history.push("/register")
  }

  //Dynamics Save Or Update
  titleDynamicsSaveOrUpdate() {
    if (this.state.id === 'create')
      return <h1 className="display-3 text-center mt-4">Üye Ekle</h1>
    else
      return <h1 className="display-3 text-center mt-4 text-uppercase">Üye Güncelle</h1>
  }

  //FORM
  onChangeUsername = (event) => {
    this.setState({
      username: event.target.value
    })
  }

  onChangeEmail = (event) => {
    this.setState({
      email: event.target.value
    })
  }

  onChangePassword = (event) => {
    this.setState({
      passwd: event.target.value
    })
  }

  //SUBMIT
  saveOrUpdateRegister = (event) => {
    //browser sen dur birşey yapma
    event.preventDefault();

    //register objesini doldurmak
    const registerDto = {
      username: this.state.username,
      email: this.state.email,
      passwd: this.state.passwd
    }
    console.log(registerDto);

    //conditional is it Create?  is it Update ?
    if (this.state.id === 'create') {//CREATE
      RegisterApiServices.createRegister(registerDto).then(
        response => {
          console.log(response);
          if (response.status === 200) {
            this.props.history.push("/register");
            alert("Eklendi")
          }
        })
    } else {//UPDATE
      RegisterApiServices.updateRegister(this.state.id, registerDto).then(
        response => {
          console.log(response);
          if (response.status === 200) {
            this.props.history.push("/register");
            alert("Güncellendi")
          }
        })
    }
  }
  //function end

  //render
  render() {
    return (
      <>
        {this.titleDynamicsSaveOrUpdate()}
        <div className="container">
          <div className="row">
            <div className="card-body shadow">

              
              {/* 
              USERNAME
              <div className="form-group mb-3">
                <label htmlFor="username">Username</label>
                <input type="text" name="username" id="username" className='form-control' 
                 placeholder='Kullanıcı Adınız' autoFocus="true"
                  onChange={this.onChangeUsername} value={this.state.username}  />
              </div> 
              */}

              {/* label, type, name, id, placeholder, autofocus, onchange, value  */}
              {/* props */}
              <CreateOrUpdateReusability 
                 label="Username" type="text" name="username" id="username"
                 placeholder="Kullanıcı Adınız" autofocus="true" 
                onchange={this.onChangeUsername} value={this.state.username} />


              {/* email */}
              <CreateOrUpdateReusability 
                 label="Email Address" type="email" name="email" id="email"
                 placeholder="Kullanıcı Emailiniz" autofocus="false" 
                onchange={this.onChangeEmail} value={this.state.email} />

              {/* passwd */}
              <CreateOrUpdateReusability 
                 label="Password " type="password" name="passwd" id="passwd"
                 placeholder="Kullanıcı Şifreniz" autofocus="false" 
                onchange={this.onChangePassword} value={this.state.passwd} />

              {/* submit */}
              <div className="form-group mt-4 mb-4">
                {/* bind kendi satırında yaptım */}
                <button className="btn btn-danger me-4" onClick={this.cancel.bind(this)}>Temizle</button>
                <button className="btn btn-primary me-4" onClick={this.saveOrUpdateRegister}>Gönder</button>
                <button className="btn btn-success" onClick={this.homePage}><i className="fa-solid fa-screwdriver-wrench me-2"></i>Admin Page</button>
              </div>
            </div>
          </div>
        </div>
      </>
    ) //end return
  } //end render
} //end class

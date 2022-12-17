import React, { Component } from 'react'
import RegisterApiServices from '../../services/RegisterApiServices'

export default class UpdateRegister extends Component {
  /* 
id
username
email
passwd
 */


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
    //this.cancel = this.cancel.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);
    this.saveOrUpdateRegister = this.saveOrUpdateRegister.bind(this);
  }

  //CDM 
  componentDidMount() {
    // EKLEME    ==> undefined 
    // GÜNCELLEME ==> 1
    //EKLEME
    if (this.state.id === 'register_add') {
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

  //Dynamics Save Or Update
  titleDynamicsSaveOrUpdate() {
    if (this.state.id === 'register_add')
      return <h1 className="display-3 text-center mt-4">Üye Ekle</h1>
    else
      return <h1 className="display-3 text-center mt-4 text-uppercase">Üye Güncelle</h1>
  }

  //function end
  //HOME
  homePage() {
    return this.props.push("/")
  }

  //CANCEL
  cancel() {
    return this.props.push("/")
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
  saveOrUpdateRegister() {

  }


  //render
  render() {
    return (
      <>
        {this.titleDynamicsSaveOrUpdate()}
        <div className="container">
          <div className="row">
            <div className="card-body shadow">

              {/* username */}
              <div className="form-group mb-3">
                <label htmlFor="username">Username</label>
                <input type="text" name="username" id="username" className='form-control' placeholder='Kullanıcı Adınız'
                  onChange={this.onChangeUsername} value={this.state.username} />
              </div>


              {/* email */}
              <div className="form-group mb-3">
                <label htmlFor="email">email</label>
                <input type="text" name="email" id="email" className='form-control' placeholder='Kullanıcı email'
                  onChange={this.onChangeEmail} value={this.state.email} />
              </div>

              {/* passwd */}
              <div className="form-group mb-3">
                <label htmlFor="passwd">passwd</label>
                <input type="text" name="passwd" id="passwd" className='form-control' placeholder='Kullanıcı passwd'
                  onChange={this.onChangePassword} value={this.state.passwd} />
              </div>

              {/* submit */}
              <div className="form-group mt-4 mb-4">
                {/* bind kendi satırında yaptım */}
                <button className="btn btn-danger me-4" onClick={this.cancel.bind(this)}>Temizle</button>
                <button className="btn btn-primary" onClick={this.saveOrUpdateRegister}>Gönder</button>
              </div>
            </div>
          </div>
        </div>
      </>
    )
  }
}

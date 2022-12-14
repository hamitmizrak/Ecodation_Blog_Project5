import React, { Component } from 'react'
import RegisterApiServices from '../../services/RegisterApiServices'
import CreateOrUpdateReusability from '../reusability/CreateOrUpdateReusability';

// Dil secenegi => withTranslation
import { withTranslation } from 'react-i18next';

//CLASS 
class CreateOrUpdateRegister extends Component {

  //constructor
  constructor(props) {
    super(props)

    //state
    this.state = {
      // id params almak
      id: this.props.match.params.id,

      //dikkat: eğer null vermezsek exception handling'te null değerleri yakalamayız.
      username: null,
      email: null,
      passwd: null,

      //spinner
      submitSpinner: false,

      //exception handling
      errors: {},

      //aynı anda 1 kere submit olsun
      submitCloseMultipleRequest: false,
    }

    //bind
    this.titleDynamicsSaveOrUpdate = this.titleDynamicsSaveOrUpdate.bind(this);
    this.homePage = this.homePage.bind(this);
    //buradaki 3 bileşen yerine sadece onChangeInput yazdım
    /*this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangeEmail = this.onChangeEmail.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);*/
    this.onChangeInput = this.onChangeInput.bind(this);
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
      return <h1 className="display-3 text-center mt-4">{this.props.t('register')}</h1>
    else
      return <h1 className="display-3 text-center mt-4 text-uppercase">{this.props.t('registerUpdate')}</h1>
  }


  // FORM input ==> 1.YOL
  /*onChangeUsername = (event) => {
    console.log(event.target.value)
    this.setState({
      username: event.target.value
    })
  }

  onChangeEmail = (event) => {
    console.log(event.target.value)
    this.setState({
      email: event.target.value
    })
  }

  onChangePassword = (event) => {
    console.log(event.target.value)
    this.setState({
      passwd: event.target.value
    })
  }*/

  // FORM input ==> 2.YOL
  onChangeInput = (event) => {
    const { name, value } = event.target;
    console.log(event.target.value)

    // exception handling
    // input içinde eğer birşey varsa in-valid kaldıralım
    // input doluysa hata vermesin
    // üç nokta (...) ==> biz bir veriyi kopyalamak için kullanıyoruz.
    const errors = { ...this.state.errors };
    errors[name] = undefined;

    //state içeriğini güncellemek
    this.setState({
      [name]: value,
      //exception handling setState
      errors
    });
  } //end onChangeInput

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

    //SPINNER TRUE
    this.setState({
      submitSpinner: true,
      submitCloseMultipleRequest: true,
    })

    //conditional is it Create?  is it Update ?
    if (this.state.id === 'create') {//CREATE
      RegisterApiServices.createRegister(registerDto).then(
        response => {
          console.log(response);

          //SPINNER FALSE
          this.setState({ submitSpinner: false, submitCloseMultipleRequest: false })
          if (response.status === 200) {
            this.props.history.push("/register");
            //alert("Eklendi")
          }
        }).catch(error => {
          console.log("CREATE Register" + error.response.data)

          // exception handling
          // bize gelen her hata validatioon olmayabilir.
          if (error.response.data.validationErrors) {
            this.setState({
              errors: error.response.data.validationErrors,
              submitCloseMultipleRequest: false,
            })
            console.log(error.response.data.validationErrors)
          }

          //SPINNER FALSE
          this.setState({
            submitSpinner: false
          })
        })
    } else {//UPDATE
      RegisterApiServices.updateRegister(this.state.id, registerDto).then(
        response => {
          console.log(response);
          //SPINNER FALSE
          this.setState({
            submitSpinner: false,
            submitCloseMultipleRequest: false

          })
          if (response.status === 200) {
            this.props.history.push("/register");
            alert("Güncellendi")
          }
        }).catch(error => {
          console.log("UPDATE Register" + error.response.data)

          // exception handling
          // bize gelen her hata validatioon olmayabilir.
          if (error.response.data.validationErrors) {
            this.setState({
              errors: error.response.data.validationErrors,
              submitCloseMultipleRequest: false,
            })
            console.log(error.response.data.validationErrors)
          }
        })

      //SPINNER FALSE
      this.setState({
        submitSpinner: false,
        submitCloseMultipleRequest: false
      })
    }
  } //end saveOrUpdateRegister
  ///////////////function end

  //render
  render() {
    //destructing spinner
    const { submitSpinner } = this.state;

    //exception handling
    const { username, email, passwd } = this.state.errors;

    //submit birden fazla kez eklenmesini önlemek
    const { submitCloseMultipleRequest } = this.state;

    //return
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
                label={this.props.t('username')} type="text" name="username" id="username"
                placeholder="Kullanıcı Adınız" autofocus={true}
                onchange={this.onChangeInput} value={this.state.username}
                error={username} />

              {/* email */}
              <CreateOrUpdateReusability
                label={this.props.t('email')} type="email" name="email" id="email"
                placeholder="Kullanıcı Emailiniz" autofocus={false}
                onchange={this.onChangeInput} value={this.state.email}
                error={email} />

              {/* passwd */}
              <CreateOrUpdateReusability
                label={this.props.t('password')} type="password" name="passwd" id="passwd"
                placeholder="Kullanıcı Şifreniz" autofocus={false}
                onchange={this.onChangeInput} value={this.state.passwd}
                error={passwd} />

              {/* submit */}
              <div className="form-group mt-4 mb-4">
                {/* bind kendi satırında yaptım */}
                <button type="reset" className="btn btn-danger me-4" onClick={this.cancel.bind(this)}>{this.props.t('clean')}</button>
                <button
                  type="submit"
                  className="btn btn-primary me-4"
                  onClick={this.saveOrUpdateRegister}
                  disabled={submitCloseMultipleRequest} >
                  {
                    submitSpinner ?
                      <div className="spinner-border text-warning spinner-border-sm" role="status">
                        <span className="sr-only">Loading...</span>
                      </div>
                      : ""
                  }
                  {this.props.t('submit')}
                </button>

                {/* admin page button*/}
                <button
                  className="btn btn-success"
                  onClick={this.homePage}>
                  <i className="fa-solid fa-screwdriver-wrench me-2"></i>{this.props.t('adminPage')}
                </button>
              </div>
            </div>
          </div>
        </div>
      </>
    ) //end return
  } //end render
} //end class

// export default UserRegister
//  Higher Order Component: monad componenti başka bir componentin içine  ekleyip oradanda yeni sonuclar elde etmek
export default withTranslation()(CreateOrUpdateRegister)
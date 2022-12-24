// stateless(durumsuz) ==> function component
// rfc =>TAB
// props: componentler arasında veri alış-verişini sağlar.
import React from 'react'

export default function CreateOrUpdateReusability(props) {
  //descructing
  //error handling  : error
  const { label, type, name, id, placeholder, autofocus, onchange, value, error } = props;

  //error handling 
  const className = name ? "is-invalid form-control mb-3" : "form-control mb-3";

  //return
  return (
    <>
      <div className="form-group mb-3">
        <label htmlFor="passwd">{label}</label>
        <input type={type} name={name} id={id}
          className={className} placeholder={placeholder} autoFocus={autofocus}
          onChange={onchange} value={value} />
          <div className="invalid-feedback">{error}</div>
      </div>
    </>
  ) //end return
} //end function


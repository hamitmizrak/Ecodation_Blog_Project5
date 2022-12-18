//stateless(durumsuz) ==> function component
//rfc =>TAB 
import React from 'react'

export default function CreateOrUpdateReusability(props) {
  //descructing
  const { label, type, name, id, placeholder, autofocus, onchange, value } = props;
  
  //return
  return (
    <>
      <div className="form-group mb-3">
        <label htmlFor="passwd">{label}</label>
        <input type={type} name={name} id={id}
          className='form-control' placeholder={placeholder} autoFocus={autofocus}
          onChange={onchange} value={value} />
      </div>
    </>
  ) //end return
} //end function


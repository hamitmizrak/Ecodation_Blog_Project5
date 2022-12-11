//rfc ==> TAB (react function componenent) Stateless
//rcc ==> TAB (react Class Component)      Statefull
//statefull: state var, render var
import React from 'react'

export default function Footer(props) {

//date
const nowDate=new Date().getFullYear();

    return (
        <>
            <div style={
                {
                    backgroundColor: "black",
                    color: "white",
                    minHeight: "20rem"
                }
            }>
                {props.special}
                <br/>
                {nowDate}
            </div>
        </>
    )
}

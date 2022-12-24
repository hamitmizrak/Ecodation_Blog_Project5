import i18n from "i18next";
import { initReactI18next } from "react-i18next";

// i18n default information created
i18n.use(initReactI18next).init({
    resources:{
        en:{
            translations: {
               'username':"Username",
               "email":"email address",
               "password":"password",
               "submit":"Submit",
               "registerAdd":"Register Add",
               "registerUpdate":"Register Update"
            } // translation
        } // end EN
        ,tr:{
            translations: {
               'username':"Kullanıcı Adı",
               "email":"email addresiniz",
               "password":"Şifreniz",
               "submit":"Gönder",
               "registerAdd":"Üye Ekle",
               "registerUpdate":"Üye Güncelle"
            } // translation
        } // end TR
    }, //end resources
    fallbackLng:'tr',
    ns:['translations'],
    defaultNS:'translations',
    keySeparator:false,
    interpolation:{
        escapeValue:false,
        formatSeparator:','
    },
    react:{
        wait:true
    }
}); // end i18next.use()

//export function
export default i18n;
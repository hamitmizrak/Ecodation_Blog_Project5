import i18n from 'i18next';
import { initReactI18next } from 'react-i18next';

i18n.use(initReactI18next).init({
    resources: {
        en:
        {
            translations: {
                'username':"Username",
               "email":"email address",
               "password":"password",
               "submit":"Submit",
               "registerAdd":"Register Add",
               "registerUpdate":"Register Update",
               "register":"Register",
               "login":"Login",
               "register_login":"register/login",
               "about":"About",
               "contact":"Contact",
               "search":"Search ...",
               "clean":"Cleaner",
               "adminPage":"Admin Page",
               "date":"Date",
               'update':"Update",
               'view':"View",
               'delete':"Delete",
            }
        },
        tr:
        {
            translations: {
               'username':"Kullanıcı Adı",
               "email":"email addresiniz",
               "password":"Şifreniz",
               "submit":"Gönder",
               "registerAdd":"Üye Ekle",
               "registerUpdate":"Üye Güncelle",
               "register":"Üye Kayıt",
               "login":"Giriş Yap",
               "register_login":"Üye Kayıt/ Giriş",
               "about":"Hakkımızda",
               "contact":"İletişim",
               "search":"Arama ...",
               "clean":"Temizle",
               "adminPage":"Admin Sayfası",
               "date":"Tarih",
               'update':"Güncelleme",
               'view':"Göster",
               'delete':"Sil",
            }
        }
    },
    fallbackLng: 'tr',    //fallbackLng: 'en', fall back function    
    ns: ['translations'], //kelimeleri nerede alsın
    defaultNS: 'translations',
    keySeparator: false,
    interpolation: { escapeValue: false, formatSeparator: ',' },
    react: {
        wait: true
    }
});
export default i18n;
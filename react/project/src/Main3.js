import {useState} from "react";
import { useLocation } from "react-router-dom";

function Main3(){
  let [id, setId] = useState('');
  let [pw, setPw] = useState('');
  const location = useLocation();
  if(location.state != null){
    let tmpId = location.state.id;
    let tmpPw = location.state.pw;
    if(location.state != null){
      setId(tmpId);
      setPw(tmpPw);
    }
    location.state = null;
  }
  return (
    <main>
      <h1>메인3</h1>
      <h2>ID : {id}</h2>
      <h2>PW : {pw}</h2>
    </main>
  )
}

export default Main3;
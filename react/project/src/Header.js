import { Link } from "react-router-dom";

function Header(){
  return (
    <header>
      <nav className="menu">
        <ul className="menu-list">
          <li className="menu-item">
            <Link to={"/"} className="menu-link">메뉴1</Link>
          </li>
          <li className="menu-item">
            <Link to={"/menu2"} className="menu-link">메뉴2</Link>
          </li>
          <li className="menu-item">
            < Link to={"/menu3"} className="menu-link">메뉴3</Link>
          </li>
        </ul>
      </nav>
    </header>
  )
}
export default Header;
import './App.css'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'
import RegisterComponent from "./components/RegisterComponent";
import LoginComponent from "./components/LoginComponent";
import {isUserLoggedIn} from "./services/AuthServices";

function App() {
  // const [count, setCount] = useState(0)


  function AuthenticatedRoute({children}){
    const isAuth = isUserLoggedIn();
    if(isAuth) {
      return children;
    }

    return <Navigate to="/" />
  }
  return (
    <>
    <BrowserRouter>
      <HeaderComponent />
        <Routes>
          <Route path='/' element = {
            <AuthenticatedRoute>
              <ListEmployeeComponent/>
            </AuthenticatedRoute>
          }/>

          <Route path='/employees' element = {
            <AuthenticatedRoute>
              <ListEmployeeComponent/>
            </AuthenticatedRoute>
          }/>

          <Route path={'/register'} element = { <RegisterComponent/> } />
          <Route path={'/login'} element = { <LoginComponent/> } />

        </Routes>
    </BrowserRouter>
    
    </>
  )
}

export default App

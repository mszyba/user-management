import './App.css'
import HeaderComponent from './components/HeaderComponent'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {
  // const [count, setCount] = useState(0)

  return (
    <>
    <BrowserRouter>
      <HeaderComponent />
        <Routes>
          <Route path='/' element = { <ListEmployeeComponent /> }></Route>
          <Route path='/employees' element = { <ListEmployeeComponent /> }></Route>

        </Routes>
    </BrowserRouter>
    
    </>
  )
}

export default App

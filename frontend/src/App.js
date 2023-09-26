import './App.css';
import Welcome from "./components/Welcome";
import Greeting from "./components/Greeting";
import Employee from "./components/Employee";

function App() {
  return (
    <div className="App">
      <p>Hello World</p>
      <Welcome firstname ="Michał" />
      <Greeting name={"dsdsdsdsd"} />
      <Employee />
    </div>
  );
};

export default App;

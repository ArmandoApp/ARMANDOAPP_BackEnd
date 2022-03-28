import './styles/Ofertantes.css'
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Ofertantes from './components/ofertantes'

function App() {
  return (
    <Router>
      <div className="App">
      
          <Routes>

            <Route path='/ofertantes' element={<Ofertantes/>}></Route>

          </Routes>
      </div>
    </Router>
  );
}

export default App;

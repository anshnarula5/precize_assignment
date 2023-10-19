import './App.css';
import Button from 'react-bootstrap/Button';
import StudentList from './components/StudentList';
import { Container } from 'react-bootstrap';

function App() {
  return (
    <div className="App bg-dark-subtle">
      <Container className='pt-3 min-vh-100'>
      <h1>Student SAT Scores</h1>
      <StudentList />
      </Container>
    </div>
  );
}

export default App;

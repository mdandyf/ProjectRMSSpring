import React from 'react';
import { Table, Panel, Button, Navbar } from 'react-bootstrap';
import "./list.css";

class List extends React.Component {
    render() {
        return (
            <div className="container">
                <Header />
                <Content />
            </div>
        );
    }
}

class Header extends React.Component {
    render() {
        return (
            <Navbar inverse={true}>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#home">PT. Mitrais - RMS</a>
                    </Navbar.Brand>
                </Navbar.Header>
                <Navbar.Collapse>
                    <Navbar.Text pullRight>
                        Signed in as: <Navbar.Link href="#">Mark Otto</Navbar.Link>
                    </Navbar.Text>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}

class Content extends React.Component {
    render() {
        return (
            <Panel>
                <Panel.Body>
                    <Button className="buttonNew" bsStyle="primary">New</Button>
                    <div>
                        <Table striped bordered condensed hover>
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Name</th>
                                    <th>User Name</th>
                                    <th>Password</th>
                                    <th>Role</th>
                                    <th>Previlege</th>
                                    <th colSpan="2">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>Mark Geiger</td>
                                    <td>mark.geiger@mitrais.com</td>
                                    <td>1234</td>
                                    <td>USER</td>
                                    <td>READ</td>
                                    <td><Button className="buttonEdit" bsStyle="info">Edit</Button></td>
                                    <td><Button className="buttonDelete" bsStyle="danger">Delete</Button></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Mark Geiger</td>
                                    <td>mark.geiger@mitrais.com</td>
                                    <td>1234</td>
                                    <td>USER</td>
                                    <td>READ</td>
                                    <td><Button className="buttonEdit" bsStyle="info">Edit</Button></td>
                                    <td><Button className="buttonDelete" bsStyle="danger">Delete</Button></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Mark Geiger</td>
                                    <td>mark.geiger@mitrais.com</td>
                                    <td>1234</td>
                                    <td>USER</td>
                                    <td>READ</td>
                                    <td><Button className="buttonEdit" bsStyle="info">Edit</Button></td>
                                    <td><Button className="buttonDelete" bsStyle="danger">Delete</Button></td>
                                </tr>
                            </tbody>
                        </Table>
                    </div>
                </Panel.Body>
            </Panel>
        );
    }
}

export default List;
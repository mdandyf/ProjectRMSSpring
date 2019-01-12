import React from 'react';
import { Table, Panel, Button, Image, Navbar } from 'react-bootstrap';
import "./list.css";

class List extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: [],
            isLoading: false,
            userLogin: "Mark Geiger"
        }
    }

    componentDidMount() {
        this.setState({ isLoading: true });

        fetch('http://localhost:8080/list/users')
            .then(response => { return response.json(); })
            .then(data => this.setState({ users: data, isLoading: false, userDetails: [] }));
    }


    render() {
        return (
            <div className="container">
                <Header myUserLogin={this.state.userLogin}/>
                <ContentList myUser={this.state.users} myLoading={this.state.myLoading} />
            </div>
        );
    }
}

class Header extends React.Component {
    render() {
        const userLogin = this.props.myUserLogin;
        return (
            <Navbar inverse={true}>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#home">PT. Mitrais - RMS</a>
                    </Navbar.Brand>
                </Navbar.Header>
                <Navbar.Collapse>
                    <Navbar.Text pullRight>
                        Signed in as: <Navbar.Link href="#">{userLogin}</Navbar.Link>
                    </Navbar.Text>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}

class ContentList extends React.Component {
    render() {
        const users = this.props.myUser.map(user => <User key={user.id} user={user} />)
        const isLoading = this.props.myLoading;
        
        if (isLoading) {
            return <p>Loading...</p>;
        }

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
                                    <th colSpan="2">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {users}
                            </tbody>
                        </Table>
                    </div>
                </Panel.Body>
            </Panel>
        );
    }
}

class User extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.user.id}</td>
                <td>{this.props.user.name}</td>
                <td>{this.props.user.userName}</td>
                <td><input className="hidetext" size={80} type="password" value= {this.props.user.password} readOnly={true}/></td>
                <td>
                    <Image rounded src="./img/pencil.png"></Image>
                </td>
                <td><Button id={this.props.user.id} className="buttonDelete" bsStyle="danger">Delete</Button></td>
            </tr>
        );
    }
}

export default List;
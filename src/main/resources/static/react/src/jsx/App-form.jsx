import React from 'react';
import { FormGroup, Button, Modal, ControlLabel, FormControl, HelpBlock } from 'react-bootstrap';

function FieldGroup({ id, label, help, ...props }) {
    return (
      <FormGroup controlId={id}>
        <ControlLabel>{label}</ControlLabel>
        <FormControl {...props} />
        {help && <HelpBlock>{help}</HelpBlock>}
      </FormGroup>
    );
  }

class Form extends React.Component {
    render() {
        return (
            <div className="static-modal">
                <Modal.Dialog>
                    <Modal.Header>
                        <Modal.Title>Create New User</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <form>
                            <FieldGroup
                                id="formControlsText"
                                type="text"
                                label="Name"
                                placeholder="Enter name"
                            />
                            <FieldGroup
                                id="formControlsUserName"
                                type="username"
                                label="User Name"
                                placeholder="Enter user name"
                            />
                            <FieldGroup id="formControlsPassword" label="Password" type="password" />

                        </form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button>Close</Button>
                        <Button bsStyle="primary">Save changes</Button>
                    </Modal.Footer>
                </Modal.Dialog>
            </div>
        );
    }
}

export default Form;
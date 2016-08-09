import React, {Component, PropTypes} from 'react'
import {connect} from 'react-redux'
import {browserHistory} from 'react-router'
import Button from 'react-bootstrap/lib/Button';
import ButtonToolbar from 'react-bootstrap/lib/ButtonToolbar';

class App extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        const {children} = this.props

        return (
            <ButtonToolbar>
                {/* Standard button */}
                <Button>Default</Button>

                {/* Provides extra visual weight and identifies the primary action in a set of buttons */}
                <Button bsStyle="primary">Primary</Button>

                {/* Indicates a successful or positive action */}
                <Button bsStyle="success">Success</Button>

                {/* Contextual button for informational alert messages */}
                <Button bsStyle="info">Info</Button>

                {/* Indicates caution should be taken with this action */}
                <Button bsStyle="warning">Warning</Button>

                {/* Indicates a dangerous or potentially negative action */}
                <Button bsStyle="danger">Danger</Button>

                {/* Deemphasize a button by making it look like a link while maintaining button behavior */}
                <Button bsStyle="link">Link</Button>
            </ButtonToolbar>
        )
    }
}

App.propTypes = {
    // Injected by React Redux  // Injected by React Router
    children: PropTypes.node
}

export default App;

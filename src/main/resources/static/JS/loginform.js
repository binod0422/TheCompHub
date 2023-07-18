//const loginURL = 'http://localhost:8080/api/form';
const loginURL = "/api/form"

document.addEventListener('DOMContentLoaded', function() {
  const form = document.getElementById('loginForm');
  const formTitle = document.getElementById('formTitle');
  const emailField = document.getElementById('emailField');
  const toggleLink = document.getElementById('toggleLink');
  let isLogin = true; // Track if it's in login mode initially

  form.addEventListener('submit', async function(event) {
    event.preventDefault(); // Prevent form submission

    const formData = {
      email: form.email.value,
      username: form.username.value,
      password: form.password.value
    };

    // Make use of the formData object based on the current mode (login or signup)
    if (isLogin) {
      delete formData.email; // Remove email field for login mode
    }

    try {
      const response = await fetch(loginURL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });

      if (response.ok) {
        console.log('Form submitted successfully');
        console.log(formData);
        form.reset(); // Reset the form
      } else {
        console.error('Request failed. Status: ' + response.status);
      }
    } catch (error) {
      console.error('Request failed:', error);
    }
  });

  toggleLink.addEventListener('click', function(event) {
    event.preventDefault(); // Prevent default link behavior

    if (isLogin) {
      formTitle.textContent = 'Sign up';
      emailField.style.display = 'block';
      toggleLink.innerHTML = 'Already have an account? <span class="underline">Login</span>';
      isLogin = false;
    } else {
      formTitle.textContent = 'Login';
      emailField.style.display = 'none';
      toggleLink.innerHTML = 'Don\'t have an account? <span class="underline">Sign up</span>';
      isLogin = true;
    }
  });
});

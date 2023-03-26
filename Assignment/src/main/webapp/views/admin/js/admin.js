document.addEventListener("DOMContentLoaded", function (event) {

    const showNavbar = (toggleId, navId, bodyId, headerId) => {
        const toggle = document.getElementById(toggleId), nav = document.getElementById(navId),
            bodypd = document.getElementById(bodyId), headerpd = document.getElementById(headerId)

        // Validate that all variables exist
        if (toggle && nav && bodypd && headerpd) {
            // check local storage for navbar state
            const isNavbarExpanded = localStorage.getItem('isNavbarExpanded') === 'true';
            if (isNavbarExpanded) {
                nav.classList.add('show')
                toggle.classList.add('bx-x')
                bodypd.classList.add('body-pd')
                headerpd.classList.add('body-pd')
            }

            toggle.addEventListener('click', () => {
                // toggle navbar
                nav.classList.toggle('show')
                toggle.classList.toggle('bx-x')
                bodypd.classList.toggle('body-pd')
                headerpd.classList.toggle('body-pd')

                // save navbar state to local storage
                const isExpanded = nav.classList.contains('show');
                localStorage.setItem('isNavbarExpanded', isExpanded);
            })
        }
    }

    showNavbar('header-toggle', 'nav-bar', 'body-pd', 'header')

    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link')

    function colorLink(event) {
        if (linkColor) {
            linkColor.forEach(l => l.classList.remove('active'))
            this.classList.add('active')
        }
        // event.preventDefault(); // prevent default behavior of a tag
    }

    linkColor.forEach(l => l.addEventListener('click', colorLink))

    // Your code to run since DOM is loaded and ready
});

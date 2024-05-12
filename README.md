# fis backend

A simple Spring Boot server to asynchronously fetch images search results from 3 different apis.  
Built for fis_app website excercise. [fis_app](https://github.com/oppahansi/fis_app)

## Response example:

<details>
  <summary>Json Response for http://localhost:8080/curated?&page=1&perSource=10</summary>
  
    {
    "total": 28499,
    "page": 1,
    "perPage": 30,
    "perSource": 10,
    "searchSources": {
        "unsplash": "https://www.unsplash.com/",
        "pixabay": "https://www.pixabay.com/",
        "pexels": "https://www.pexels.com/"
    },
    "images": [
        {
            "url": "https://www.pexels.com/photo/cordillera-de-los-andes-chile-23492498/",
            "preview": "https://images.pexels.com/photos/23492498/pexels-photo-23492498.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "Cordillera de los Andes, Chile",
            "photographer": "https://www.pexels.com/@made-in-uruguay-1241789989",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
       ...
        {
            "url": "https://pixabay.com/photos/church-church-tower-dusk-bell-tower-8615302/",
            "preview": "https://pixabay.com/get/g6db510102eea7f870e68d25b0a11bcb3de4ebc8dc33508a5821b9188a373eb58522e61afa4b8b49fd506f858f8680b628296765b204d46afb8fa7a45c78c5896_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/fietzfotos",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        ...
        {
            "url": "https://unsplash.com/photos/a-vase-filled-with-white-flowers-on-top-of-a-table-FkQT9PXZIM0",
            "preview": "https://images.unsplash.com/photo-1713494500139-a0d182b60cb8?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHw4fHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "a vase filled with white flowers on top of a table",
            "photographer": "https://unsplash.com/@babybluecat",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
      ...
      ]
    }

</details>

# fis backend

A simple Spring Boot server to asynchronously fetch images search results from 3 different apis.  
Built for fis_app website excercise. [fis_app](https://github.com/oppahansi/fis_app)

## Response example:

<details>
  <summary>Json Response</summary>

    http://localhost:8080/curated?&page=1&perSource=10  

  
    ```json
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
        {
            "url": "https://www.pexels.com/photo/chez-les-lilliputiens-23643387/",
            "preview": "https://images.pexels.com/photos/23643387/pexels-photo-23643387.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "chez les lilliputiens",
            "photographer": "https://www.pexels.com/@rubis",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://pixabay.com/photos/church-church-tower-dusk-bell-tower-8615302/",
            "preview": "https://pixabay.com/get/g6db510102eea7f870e68d25b0a11bcb3de4ebc8dc33508a5821b9188a373eb58522e61afa4b8b49fd506f858f8680b628296765b204d46afb8fa7a45c78c5896_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/fietzfotos",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://pixabay.com/photos/ferris-wheel-amusement-park-ride-8428738/",
            "preview": "https://pixabay.com/get/g73d09e53f575b9213d9836e65b7475f04f2289b83832bcd0df99059d0ac4b3f7377671c394eabaf2fe3119c141cb29d7edc24510b021ea9c6c194f8f5fc84868_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/我见青山多妩媚",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://www.pexels.com/photo/a-person-pouring-sauce-over-a-bowl-of-soup-23220513/",
            "preview": "https://images.pexels.com/photos/23220513/pexels-photo-23220513.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "",
            "photographer": "https://www.pexels.com/@lawlesscapture",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://pixabay.com/photos/boat-fishing-boat-sea-beach-8614314/",
            "preview": "https://pixabay.com/get/ga0dcf69d2fa7881a080bcdb28c47e985481057b36231c3dfc5b2cd631b52f7ac773ff3ccd6cdb7598129e76ee6da5819874bea1f1edd8e89f5b0db5ec5cd5519_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/Peggychoucair",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://pixabay.com/photos/forsythia-flowers-branch-8595521/",
            "preview": "https://pixabay.com/get/gb83284b3e1199982d7a42dabc9b835197618c3644e162d238e02112d52c459ed74c950b7b21fcd6bdcebf5bc42d227496ced1f839e4420d31efec10dbdd98c65_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/Mylene2401",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://www.pexels.com/photo/person-walking-with-flashlight-among-rocks-at-night-22940322/",
            "preview": "https://images.pexels.com/photos/22940322/pexels-photo-22940322.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "La cueva oculta 💫",
            "photographer": "https://www.pexels.com/@horacio-lander-1239977167",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-vase-filled-with-white-flowers-on-top-of-a-table-FkQT9PXZIM0",
            "preview": "https://images.unsplash.com/photo-1713494500139-a0d182b60cb8?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHw4fHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "a vase filled with white flowers on top of a table",
            "photographer": "https://unsplash.com/@babybluecat",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://pixabay.com/photos/dahlia-flower-plant-petals-bloom-8587940/",
            "preview": "https://pixabay.com/get/g7d10d599a10f88e8d88a6df9acae965d0b0939c2f61591f797539e17a607eaa9ae22f93fd3cdb798f2a9d3ff1c46ecb2db855488aa7cb170a48712d736ec2147_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/HeiKiwi",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-view-of-a-city-with-tall-buildings-aA32ilNrjho",
            "preview": "https://images.unsplash.com/photo-1714904244831-1cb33ead836c?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHw3fHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "a view of a city with tall buildings",
            "photographer": "https://unsplash.com/@jo_negatives",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://www.pexels.com/photo/black-and-white-23660473/",
            "preview": "https://images.pexels.com/photos/23660473/pexels-photo-23660473.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "",
            "photographer": "https://www.pexels.com/@efrem-efre-2786187",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://pixabay.com/photos/zoo-parrot-bird-animal-nature-8378189/",
            "preview": "https://pixabay.com/get/g76af62fd6d28d580b15d3208984c81a3c907fc4e444d6094f128181770ad0415ba426284ed638835b8a46421b18a2081faa15a3ce28249a2857828bdaa85d2d0_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/Zsolt71",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://pixabay.com/photos/sunset-lake-water-reflection-8424565/",
            "preview": "https://pixabay.com/get/g3cbb554200b9803d2f45c5cd714971ca6f02eadd04a04051fcaeab502a65b5ec04423a91dacfbe0d71c5de34d23f98059ae3aca4245e90386c2e818d9b8cf4bc_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/MaabHasan",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://pixabay.com/photos/vietnam-woman-everyday-life-8420600/",
            "preview": "https://pixabay.com/get/gb90ffcb847f85c06f3ab57ae6aff70b646785bec5015c7267bc80757028faa4df36eb24a7c69c0034f1d3a59bbe45fe2f9814a73770d611aebea6326c72e7623_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/sdg_Rai",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-black-and-white-photo-of-a-tall-building-xMNMakJiIAQ",
            "preview": "https://images.unsplash.com/photo-1715156153744-d5fd2f1f66eb?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHwxfHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "Polygonal",
            "photographer": "https://unsplash.com/@korkhau",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-close-up-of-a-persons-stomach-with-a-white-background-1drYbADh0P8",
            "preview": "https://images.unsplash.com/photo-1714547509090-f45fc1dbe955?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHwxMHx8fHx8fDJ8fDE3MTU1MTA5MTF8\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "By FAKURIANDESIGN",
            "photographer": "https://unsplash.com/@fakurian",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://pixabay.com/photos/goose-bird-green-grass-sunlight-8740266/",
            "preview": "https://pixabay.com/get/ga336abac60992e9df3a8771bb135bdb221c59246000782932a1be8a26478c35784d05eacb12e78d65b6f275deca992591047414a5cebd99904f04f4464b10d2a_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/snoopy42",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://www.pexels.com/photo/a-couple-sitting-in-a-room-with-a-window-23698646/",
            "preview": "https://images.pexels.com/photos/23698646/pexels-photo-23698646.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "Free stock photo of gathering, indoor, interior",
            "photographer": "https://www.pexels.com/@thanh-luu-29104820",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-man-standing-on-an-escalator-in-a-building-sEJRFDCNwwg",
            "preview": "https://images.unsplash.com/photo-1714986180824-775a667f7ec6?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHw2fHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "A man reaches to the top",
            "photographer": "https://unsplash.com/@fumirin",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-body-of-water-surrounded-by-trees-and-rocks-czFiTg4s3RI",
            "preview": "https://images.unsplash.com/photo-1639588645806-e42a75a37190?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHw5fHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "Low aerial shot of the Samuel H. Boardman Corridor",
            "photographer": "https://unsplash.com/@levijackson",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-painting-of-people-walking-around-a-building-8RrrD0FTpuY",
            "preview": "https://images.unsplash.com/photo-1714334544535-4c5eddeb0ec1?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHw1fHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "Artist Utagawa Hiroshige Title Mishima—No. 12, from the series \"Fifty-three Stations of the Tokaido (Tokaido gojusan tsugi),\" also known as the Reisho Tokaido Place Japan (Artist\u0027s nationality:) Date 1842–1857 Medium Color woodblock print; oban https://www.artic.edu/artworks/18287/mishima-no-12-from-the-series-fifty-three-stations-of-the-tokaido-tokaido-gojusan-tsugi-also-known-as-the-reisho-tokaido",
            "photographer": "https://unsplash.com/@artchicago",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-couple-of-men-standing-on-top-of-a-beach-TX-wCxKx2mg",
            "preview": "https://images.unsplash.com/photo-1715452317871-1f5ec80c516b?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHwzfHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "Sunset surf",
            "photographer": "https://unsplash.com/@timmossholder",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://www.pexels.com/photo/close-up-of-woman-in-jeans-and-a-trench-sitting-and-holding-a-cup-of-coffee-23336611/",
            "preview": "https://images.pexels.com/photos/23336611/pexels-photo-23336611.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "A woman is holding a cup of coffee",
            "photographer": "https://www.pexels.com/@suedadilli",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-black-and-white-photo-of-a-circular-object-Z7O09buGKTQ",
            "preview": "https://images.unsplash.com/photo-1715464502545-090ee1dc122f?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHwyfHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "a black and white photo of a circular object",
            "photographer": "https://unsplash.com/@fakurian",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        },
        {
            "url": "https://www.pexels.com/photo/beach-basketball-b-w-23639779/",
            "preview": "https://images.pexels.com/photos/23639779/pexels-photo-23639779.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "",
            "photographer": "https://www.pexels.com/@lukas-rodriguez-1845331",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://pixabay.com/photos/heliconia-lobster-claws-flora-8599119/",
            "preview": "https://pixabay.com/get/gda53eedefcba22bb727352e572684f4fc2d306441a2e7298cf6d8b5044e15e2f241e24055fc9b46f7c06281532eb2d4a2f42ecfe8c2d524f4b195e2166dc29f5_640.jpg",
            "description": "",
            "photographer": "https://pixabay.com/users/ignartonosbg",
            "license": "https://www.pixabay.com/service/license-summary/",
            "source": "https://www.pixabay.com/"
        },
        {
            "url": "https://www.pexels.com/photo/flowerpot-with-white-flowers-23228727/",
            "preview": "https://images.pexels.com/photos/23228727/pexels-photo-23228727.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "A small vase with flowers on top of a white table",
            "photographer": "https://www.pexels.com/@alena-yanovich-37077498",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://www.pexels.com/photo/a-room-with-a-book-shelf-and-a-fireplace-23698638/",
            "preview": "https://images.pexels.com/photos/23698638/pexels-photo-23698638.jpeg?auto\u003dcompress\u0026cs\u003dtinysrgb\u0026h\u003d650\u0026w\u003d940",
            "description": "Free stock photo of bookshelf, coffee, home decoration",
            "photographer": "https://www.pexels.com/@thanh-luu-29104820",
            "license": "https://www.pexels.com/license/",
            "source": "https://www.pexels.com/"
        },
        {
            "url": "https://unsplash.com/photos/a-tall-building-with-a-clock-on-the-side-of-it-lv8unel9SCI",
            "preview": "https://images.unsplash.com/photo-1715239306718-247eac556aa6?crop\u003dentropy\u0026cs\u003dtinysrgb\u0026fit\u003dmax\u0026fm\u003djpg\u0026ixid\u003dM3w1NDQ2Nzd8MHwxfGFsbHw0fHx8fHx8Mnx8MTcxNTUxMDkxMXw\u0026ixlib\u003drb-4.0.3\u0026q\u003d80\u0026w\u003d400",
            "description": "a tall building with a clock on the side of it",
            "photographer": "https://unsplash.com/@kingkonggeorge",
            "license": "https://www.unsplash.com/license/",
            "source": "https://www.unsplash.com/"
        }
    ]
}

    ```
</details>
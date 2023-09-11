export const json =
    {
        "title": "Rate My Place of Worship",
        "description": "Please rate your satisfaction on a scale of 1 to 10, with 1 being very dissatisfied and 10 being very satisfied",
        "logoPosition": "right",
        "pages": [
            {
                "name": "page1",
                "elements": [
                    {
                        "type": "text",
                        "name": "placeOfWorshipId",
                        "title": "Place Of Worship Id",
                        "valueName": "placeOfWorshipId",
                        "isRequired": true,
                        "validators": [
                            {
                                "type": "expression"
                            }
                        ],
                        "placeholder": "Please paste Id here"
                    },
                    {
                        "type": "dropdown",
                        "name": "gender",
                        "title": "Gender",
                        "isRequired": true,
                        "choices": [
                            {
                                "value": "MALE",
                                "text": "Male"
                            },
                            {
                                "value": "FEMALE",
                                "text": "Female"
                            },
                            {
                                "value": "PREFER_NOT_TO_SAY",
                                "text": "Prefer not to say"
                            },
                        ]
                    },
                    {
                        "type": "dropdown",
                        "name": "age",
                        "title": "Age Group",
                        "isRequired": true,
                        "choices": [
                            {
                                "value": "X0TO20",
                                "text": "0-20"
                            },
                            {
                                "value": "X21TO40",
                                "text": "21-40"
                            },
                            {
                                "value": "X41TO60",
                                "text": "41-60"
                            },
                            {
                                "value": "X61Plus",
                                "text": "61+"
                            },
                            {
                                "value": "PREFER_NOT_TO_SAY",
                                "text": "Prefer not to say"
                            }
                        ]
                    },
                    {
                        "type": "dropdown",
                        "name": "ethnicity",
                        "title": "Ethnicity",
                        "isRequired": true,
                        "choices": [
                            {
                                "value": "AFRICAN",
                                "text": "African"
                            },
                            {
                                "value": "ASIAN",
                                "text": "Asian"
                            },
                            {
                                "value": "EUROPEAN",
                                "text": "European"
                            },
                            {
                                "value": "MIXED_HERITAGE",
                                "text": "Mixed Heritage"
                            },
                            {
                                "value": "NORTH_AMERICAN",
                                "text": "North - American"
                            },
                            {
                                "value": "SOUTH_AMERICAN",
                                "text": "South - American"
                            },
                            {
                                "value": "PREFER_NOT_TO_SAY",
                                "text": "Prefer not to say"
                            }
                        ]
                    },
                    {
                        "type": "rating",
                        "name": "welcomingAtmosphere",
                        "title": "Rate the welcoming atmosphere",
                        "description": "A welcoming atmosphere is one that makes people feel comfortable, relaxed, and appreciated. It is an environment where people feel like they can be themselves and belong. ",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "facilities",
                        "title": "Rate the prayer facilities",
                        "description": "Prayer facilities are spaces that are dedicated to prayer and meditation",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "toilet",
                        "title": "Rate the toilet facilities",
                        "description": "Cleanliness, maintenance, accessibility, privacy, amenities, location and security of the toilet facilities",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "carParking",
                        "title": "Rate the car parking facilities",
                        "description": "Number of spaces, size of spaces, accessibility, security, lighting and signage of car parking facility",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "publicTransport",
                        "title": "Rate the accessibility by public transport",
                        "description": "Public transport is a system of transportation that is available for use by the general public",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "cycle",
                        "title": "Rate the facilities for cycling users",
                        "description": "Number of spaces, size of spaces, accessibility, security, lighting and signage of cycling facility",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "disabled",
                        "title": "Rate the facilities for disabled users",
                        "description": "Accessible ramps, walkways, parking, toilets, elevators and signage ",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "community",
                        "title": "Rate the communities facilities",
                        "description": "Community facilities are physical places that are used by the community for a variety of purposes, such as recreation, education, social activities, and cultural events",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "youngPeople",
                        "title": "Rate the facilities for young people",
                        "description": "Young people facilities are important because they provide a safe and supportive environment for young people to learn, grow, and have fun. They can also help young people to develop their skills and talents, and to connect with other young people.",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "rating",
                        "name": "interCommunity",
                        "title": "Rate the inter community activities",
                        "description": "The term \"intercommunity facilities\" refers to facilities that are shared by two or more communities. They can be used for a variety of purposes, such as recreation, education, and transportation.",
                        "showCommentArea": true,
                        "commentText": "Comments",
                        "rateCount": 10,
                        "rateMax": 10
                    },
                    {
                        "type": "text",
                        "name": "languages",
                        "title": "Which languages are spoken at your place of worship?",
                        "description": "If multiple languages are spoken, please separate by a comma in your list"
                    },
                    {
                        "type": "text",
                        "name": "comments",
                        "title": "Any other comments"
                    }
                ],
                "title": "QUESTIONS"
            }
        ]
    }

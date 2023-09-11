1 - Commencer par faire la séparation en modules  
2 - Isoler le domaine de la techno de persistence  
3 - Isoler l'application  
    - Créer une API avec des input/output différents de ceux de l'adapter (ccontroller)  
    - Créer des ports secondaires pour se découpler du système de persistence  
    - retirer spring (ça peut être discuté concernant la gestion des transactions ou de la sécurité)  
4 - Encapsuler les invariants du domaine dans le module domaine.  
    - Faire descendre les invariants dans les entités  
    - Possibilité de faire descendre certains invariants incompatibles avec les entités dans des services du domaine. Dans ce cas, il faudra penser à distinguer les ports secondaires de type repository des autres et les mettre dans le module domaine.  
5 - Tester (Ce qui est la première chose que l'on aura dû faire avant de refacto... Mais incompatible avec le déroulé de la formation :p)

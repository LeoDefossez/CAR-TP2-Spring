# Etapes de réalisation du TP
1. Developper une application de gestion de stocks (Avec Spring et controller)
   - Dans l'app Stock
2. Ajouter la possibilité de soumettre une commande 
    - Dans l'app command
3. Faire le liens entre l'application de gestion de stcck et de gestion de commandes à l'aide de kafka 
    - Dans l'app commande : production de message 
    - Dans l'app stock : comsommation de message
4. Afficher la liste des articles disponible avec leurs quantité en stock 
   - Dans l'app stock : affichage
5. être capable de mettre à jour le stock lorsque qu'une commande est reçue
   - Dans l'app stock 
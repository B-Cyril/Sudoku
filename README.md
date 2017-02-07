# Sudoku

Développement d’un Sudoku sur plateforme Android.

Le Sudoku est composé de trois activités :
- Activité principale, elle permet de choisir le niveau de sudoku que l’on désire faire (choix entre 3 niveaux de difficultés).
- Activité secondaire, elle permet de lister les grilles correspondantes au niveau de difficulté choisi.
- Troisième Activité, la grille de jeu du sudoku.

Principales fonctionnalités :
- Chargement de grilles de sudoku différentes selon le niveau et la difficulté.
- Possibilité de remplir et d'effacer des chiffres dans le sudoku (possibilité de finir une grille).
- Les nouveaux chiffres remplis sont écrits en bleu et sont les seuls effaçables avec la gomme.

Améliorations possibles :
- Stockage des grilles dans la base de donnée pour sauvegarder l'avancement de la grille.
- Rajout du niveau de % d'avancement de la grille.
- Position en dur, rendre responsive. L'application est bloquée en portrait pour éviter ce problème.

Organisation du code
- La grille du sudoku est dessinée à l'aide du canvas.DrawText et canvas.DrawLine lors de l'initialisation. Ensuite à chaque modification, la grille est redessinée en regardant les valeurs de la classe Case qui contient les nouvelles valeurs enregistrées des chiffres de la grille. 

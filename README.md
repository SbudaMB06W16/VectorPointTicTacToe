# Vector-based point ownership and destruction model for TicTacToe
Tic Tac Toe game implementing the Vector-Based Point Ownership and Destruction model

Title: A Novel Vector-Based Point Ownership and Destruction Model for Strategic Gameplay

Author: Sibusiso Mahlangu

Abstract: This paper introduces a novel game-theoretic model—Vector-Based Point Ownership and Destruction (VPOD)—that redefines how players interact with potential win conditions in grid-based strategy games. Unlike traditional win-check algorithms, this method transforms every playable line (vector) into a strategic asset that can be owned, contested, or destroyed through dynamic gameplay. We detail the model abstractly and then demonstrate its application in the game of Tic Tac Toe. The system offers emergent play, deeper decision trees, and real-time score evolution. We also compare this method with existing evaluation functions in AI game engines, emphasizing its originality and educational value.


---

1. Introduction to the VPOD Model The Vector-Based Point Ownership and Destruction (VPOD) model introduces a new framework for competitive turn-based games where win conditions are structured around paths (vectors). In VPOD, each vector is a potential win path and is treated as a dynamic resource. When a player places a marker in a cell, they gain ownership of all vectors that pass through that cell. This ownership is not absolute; if an opponent later plays in the same vector, they block or destroy it, reducing the original player's score and chances of winning. This model adds a fluid, territory-like system to games, introducing strategy, tension, and real-time adaptation.

Unlike static game state evaluations, VPOD tracks the evolution of opportunity. It considers not only current positions but also the degradation or reinforcement of strategic paths. This changes the traditional binary win/lose evaluation into a resource management simulation.

2. Core Mechanics of the VPOD Model

Each cell on a grid has a point weight (based on strategic value or potential control).

When a player marks a cell, they inherit ownership of all vectors that pass through it.

If an opponent later places a marker in one of these vectors, it becomes contested and is marked as destroyed.

Destroyed vectors deduct points from the original owner, modeling resource loss.

Victory occurs when a player controls an entire vector with their markers.

A tie occurs when all vectors are destroyed or all points are neutralized.


3. Implementation in Tic Tac Toe We implemented VPOD in the classic game of Tic Tac Toe to demonstrate its effectiveness. Each cell is assigned a weight:

Center: 4 points

Corners: 3 points

Edges: 2 points


Players gain points by claiming cells and vectors. Opponents can destroy vectors by interrupting their continuity, simulating an economy of strategic potential. This turns a previously solved game into a dynamic one with nuanced decision-making.

The implementation in Java Swing includes:

Real-time score updates

Dynamic vector ownership tracking

Tie detection based on vector exhaustion

Visual cues and GUI feedback


4. Comparison with Traditional Systems Traditional systems like Minimax, Alpha-Beta pruning, or Monte Carlo Tree Search evaluate static board states. They lack mechanisms for treating strategic pathways as mutable assets. Chess engines track threats and mobility but not vector-level resource control. VPOD instead models the depletion of winning potential, akin to territorial games or war simulations.

5. Implications for Other Games VPOD could be applied to:

Chess: Modeling control over diagonals, files, or open lines

Connect Four: Treating each line segment as a vector to contest

Go/Reversi: Assigning dynamic weights and contesting regions

Turn-based Strategy Games: Area control mechanics via vector influence


6. Personal Reflection and Philosophy To me, this model reflects how conflict plays out in life—not in absolutes but in the erosion or strengthening of possible outcomes. Each move is not just a claim to space but a disruption of future possibility. I believe this model reveals an intuitive structure of strategy and intention that traditional win-check systems miss. I’ve applied how my mind intuitively reads control, threat, and destruction into gameplay mechanics. Sharing this gives meaning to a creative impulse I've long felt.

7. Conclusion The Vector-Based Point Ownership and Destruction model introduces emergent complexity to even the simplest games. It elevates deterministic systems into adaptive, contestable environments. This framework invites new AI training models, educational tools, and experimental game designs that explore territory, influence, and decision evolution.

8. References:

Norvig, P., & Russell, S. (2021). Artificial Intelligence: A Modern Approach. Pearson.

Browne, C., Powley, E., et al. (2012). A Survey of Monte Carlo Tree Search Methods. IEEE Trans. Comp. Intell.

Stockfish Chess Engine. (2024). https://stockfishchess.org/

OpenAI. (2024). Reinforcement Learning with Human Feedback. https://openai.com/research

GitHub Repository (TBD): Vector Point System by Sibusiso Mahlangu

ChatGPT Log with Author: https://chat.openai.com/share



---

For correspondence: sibusisomahlangu0611@gmail.com


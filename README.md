# Contribuidores

O projeto só pôde ser realizado com a colaboração dos seguintes participantes: 

- Fabio Nalini (@fabnalini)
- Ícaro Onofre (@icaro-onofre)
- Saul Gabriel Castillo Tercero (@CastilloSGT)

Agradecimento muito especial à:

- Daniel Antunes (@dannesx)

## Sobre o projeto

`Power UP!` é um jogo de cartas no formato arcade, onde seu objetivo é conquistar os `5` andares do calabouço. Cada andar possui um inimigo a enfrentar, e o jogador deve utilizar seu deck de cavaleiros e cartas mágicas para combatê-lo. Quando um inimigo é derrotado, o jogador avança para o próximo andar, onde um inimigo ainda mais poderoso o aguarda!

OBS: Para uma melhor experiência de jogo, utilize o Visual Studio Code.

## Resumo

- Jogo simples de cartas;
- Baseado no universo da trilogia Dark Souls;
- Consiste entre o jogador versus a máquina (sem Inteligência Artificial);
- Maximizar o dano possível por ataque dos cavaleiros utilizando as cartas mágicas é o intuito do jogo.

## Batalha

- Ao iniciar o jogo ou ao subir de andar, o jogador colide com um inimigo.
- O jogador escolhe e utiliza até `3` cartas das `7` que possui em sua mão atual.
- Ao final de cada turno, os cavaleiros do jogador atacam o inimigo.
   - Caso o jogador destrua o inimigo, sobe-se de andar e o jogo continua.
   - Caso contrário, a batalha continua até que um dos dois sejam destruídos.

## Variáveis Globais

| Variável                  | Tipo     | Restrições              |
| ------------------------- | -------- | ----------------------- |
| Vida do jogador           | `<int>`  | playerHealth >= 1       |
| Pontuação do jogador      | `<int>`  | score >= 0              |
| Quantid. de cavaleiros    | `<int>`  | knightQuantity >= 1     |
| Poder dos cavaleiros      | `<int>`  | knightPower >= 1        |
| Poder final               | `<int>`  | finalDamage = knightQuantity * knightPower        |
| Quantid. de cartas usadas | `<int>`  | usedCards <= 3          |

## Cartas `<Object>`

- Existem `5` tipos de cartas diferentes.
- Uma classe de `Objects` que possuem ID `int`, nome `string`, descrição `string` e chamam uma magia específica.
- Cada carta altera o andamento do jogo de alguma forma.

### Tipos

| ID | Nome       | Descrição                                                                |
| -- | ---------- | ------------------------------------------------------------------------ |
| 01 | Curar      | Cura 5 pontos de vida, mas elimina 1 cavaleiro                           |
| 02 | Recrutar   | Aumenta em 2 a quantidade total de cavaleiros                            |
| 03 | Reunir     | Aumenta o poder de cada cavaleiro baseado na quantidade total            |
| 04 | Sacrificar | Sacrifica 2 cavaleiros, mas aumenta em 1 ponto o poder de cada cavaleiro |
| 05 | Treinar    | Aumenta em 1 ponto o poder de cada cavaleiro                             |

## Deck `<Stack>`

- O Deck é gerado como uma pilha.
- Possui `7` cartas geradas aleatóriamente.
- Ao iniciar o jogo ou subir de andar, as cartas são removidas da pilha e adicionadas à mão do jogador.

## Mão `<ArrayList>`

- Possui sempre 7 cartas. 
- Pode-se utilizar até 3 cartas por turno. 
- Ao final de cada turno, o jogo preenche a mão do jogador com novas cartas.

## Inimigos `<Object>`

Uma classe de `Objects` que possuem nome `string`, vida `int` e poder `int` pré-determinados.

## Andares `<Array>`

- Possui 5 andares, cada um possuindo um inimigo diferente.
- Cada índice do array recebe um `Object` do tipo `Inimigo`.
- A cada novo andar, a mão do jogador recebe novas cartas.

## Progressão do jogo `<Object>`

- Ao progredir naturalmente pelo jogo, o jogador vai acionando certos triggers que retornam informações importantes sobre o andamento do jogo.

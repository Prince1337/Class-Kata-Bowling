# Class-Kata-Bowling

Entwickle eine Klasse zur Zählung von Bowling-Spielen.

Ein Bowling-Spiel besteht aus Würfen (engl. roll), um 10 Pins am Ende der Bowling-Bahn abzuräumen. Mit jedem Wurf können also 0 bis 10 Pins umgeworfen werden. Pro Runde hat ein Spieler max. 2 Würfe, um die 10 Pins abzuräumen.

Würfe werden zu Rahmen (engl. frame) zusammengefasst, die jeweils eine Punktzahl zugeordnet bekommen. Ein Spiel besteht aus 10 Runden oder Rahmen.

Wieviele Würfe pro Runde von einem Spieler gemacht werden dürfen, hängt davon ab, wieviele Pins mit ihnen geworfen werden:

Wenn der erste Wurf eines Spielers alle 10 Pins abräumt (engl. strike), ist er der einzige Wurf in der Runde.
Ansonsten enthalten die Rahmen immer zwei Würfe, jeder mit 0 bis 10 Pins.
Ausnahme: Wenn der 10. Rahmen als ersten Wurf einen strike enthält oder beide Würfe zusammen einen spare (s.u.) ergeben, dann kann ein drittes Mal geworfen werden.
Für die Berechnung der Punktzahl eines Rahmens gibt es einige Regeln:

Ein Rahmen, dessen beide Würfe zusammen maximal 9 Pins gerissen haben, erhält die Summe der Pins als Punktzahl.
Ein Rahmen dessen beide Würfe zusammen 10 Pins berissen haben (engl. spare), erhält als Punktzahl 10 + die Zahl der Pins des nächsten Wurfes.
Ein Rahmen mit einem strike erhält als Punktzahl 10 + die Summe der Pins der nächsten beiden Würfe.
Bei Robert C. Martin findet sich diese Darstellung [1] für ein Bowling-Spiel:



Jeder Rahmen zeigt den ersten und zweiten und beim letzten sogar den dritten Wurf mit ihren Pins sowie die kummulierte Punktzahl. Ist das Kästchen für den zweiten Wurf halb ausgefüllt, liegt ein spare vor, ist es ganz ausgefüllt, war der erste Wurf ein strike.

Das Interface der Klasse soll wie folgt aussehen:

# class Game {
	- void AddRoll(int pins) {...}
	- Frame[] Frames() {...}
	- int TotalScore() {...}
	- bool Over() {...}
# }

# class Frame {
	int[] PinsRolled;
	int Score; // Punktzahl nur dieses Frame
# }
AddRoll() wirft eine Exception, falls nach Spielende noch Würfe registriert werden sollen.




unit FuncoesDLL;

interface
  Function AbrePortaSerial(dados:AnsiString):Integer; stdcall; external 'E1_Poste01.dll'
  Function FechaPortaSerial():Integer; stdcall; external 'E1_Poste01.dll'

  Function LigaLedVerde():Integer; stdcall; external 'E1_Poste01.dll'
  Function DesligaLedVerde():Integer; stdcall; external 'E1_Poste01.dll'

  Function LigaLedAmarelo():Integer; stdcall; external 'E1_Poste01.dll'
  Function DesligaLedAmarelo():Integer; stdcall; external 'E1_Poste01.dll'

  Function LigaLedVermelho():Integer; stdcall; external 'E1_Poste01.dll'
  Function DesligaLedVermelho():Integer; stdcall; external 'E1_Poste01.dll'

  Function LigaSirene():Integer; stdcall; external 'E1_Poste01.dll'
  Function DesligaSirene():Integer; stdcall; external 'E1_Poste01.dll'

implementation

end.

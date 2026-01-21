# ===================================================================================================================================================
import ctypes
import platform
import os
import time

# ===================================================================================================================================================
base_path = os.path.dirname(os.path.abspath(__file__))

# ===================================================================================================================================================
if platform.system() == "Windows":    
    poste = ctypes.WinDLL("./E1_Poste01.dll")

# Poste =============================================================================================================================================
def AbrePortaSerial(porta):
    fn = poste.AbrePortaSerial
    fn.restype = ctypes.c_int
    fn.argtypes = [ctypes.c_char_p]

    porta = ctypes.c_char_p(porta.encode('utf-8'))
    
    return fn(porta)

# --------------------------------------------------------------------------------------------------------------------------
def FechaPortaSerial():
    fn = poste.FechaPortaSerial
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------
def LigaLedVermelho(): 
    fn = poste.LigaLedVermelho
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------    
def DesligaLedVermelho(): 
    fn = poste.DesligaLedVermelho
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------    
def LigaLedAmarelo(): 
    fn = poste.LigaLedAmarelo
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------    
def DesligaLedAmarelo(): 
    fn = poste.DesligaLedAmarelo
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------    
def LigaLedVerde(): 
    fn = poste.LigaLedVerde
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------    
def DesligaLedVerde(): 
    fn = poste.DesligaLedVerde
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------    
def LigaSirene(): 
    fn = poste.LigaSirene
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------    
def DesligaSirene(): 
    fn = poste.DesligaSirene
    fn.restype = ctypes.c_int

    return fn()

# --------------------------------------------------------------------------------------------------------------------------
def GetID():
    fn = poste.GetID
    fn.restype = ctypes.c_char_p

    return fn()

# Rotina de teste ===================================================================================================================================
if __name__ == "__main__":       
    TEMPO = 1

    print("\nPOSTE SINALIZADOR ====================================================================\n")     
    print("Comando AbrePortaSerial    : " , AbrePortaSerial("COM30"), "\n")    
    
    print("Comando getID              : " , GetID(), "\n")
    time.sleep(TEMPO)

    print("Comando LigaLedVerde       : " , LigaLedVerde(), "\n")    
    time.sleep(TEMPO)

    print("Comando LigaLedAmarelo     : " , LigaLedAmarelo(), "\n") 
    time.sleep(TEMPO)
    
    print("Comando LigaLedVermelho    : " , LigaLedVermelho(), "\n") 
    time.sleep(TEMPO)
    
    print("Comando LigaSirene         : " , LigaSirene(), "\n")       
    time.sleep(TEMPO)
 
    print("Comando DesligaLedVerde    : " , DesligaLedVerde(), "\n")  
    time.sleep(TEMPO)

    print("Comando DesligaLedAmarelo  : " , DesligaLedAmarelo(), "\n")  
    time.sleep(TEMPO)
    
    print("Comando DesligaLedVermelho : " , DesligaLedVermelho(), "\n")    
    time.sleep(TEMPO)

    print("Comando DesligaSirene      : " , DesligaSirene(), "\n")        
    time.sleep(TEMPO)

    print("Comando FechaPortaSerial   : " , FechaPortaSerial(), "\n")       
    time.sleep(TEMPO)
    
# ===================================================================================================================================================
# import torchaudio
# import speechbrain as sb
# from IPython.display import Audio
# from speechbrain.dataio.dataio import read_audio
# from speechbrain.pretrained import SpeakerRecognition
# from speechbrain.pretrained import EncoderDecoderASR
# from speechbrain.pretrained import SepformerSeparation as separator
# import time
# # Inicia o cronômetro
# inicio = time.time()
# asr_model = EncoderDecoderASR.from_hparams(source="speechbrain/asr-crdnn-rnnlm-librispeech", savedir="pretrained_models/asr-crdnn-rnnlm-librispeech")
# print(asr_model.transcribe_file('exemplo_convertido.wav'))
# tempo_decorrido = time.time() - inicio
# print(f"Tempo decorrido: {tempo_decorrido} segundos"

#  with open("saida.txt", "w") as arquivo:
#     #arquivo.write(stdout.decode())
#     arquivo.write(asr_model.transcribe_file('exemplo_convertido.wav'))
#     #arquivo.write(print(f"Tempo decorrido: {tempo_decorrido} segundos"))

import torchaudio
import speechbrain as sb
from IPython.display import Audio
from speechbrain.dataio.dataio import read_audio
from speechbrain.pretrained import EncoderDecoderASR
from speechbrain.pretrained import SepformerSeparation as separator
import time
import sys

# Inicia o cronômetro
inicio = time.time()
asr_model = EncoderDecoderASR.from_hparams(source="speechbrain/asr-crdnn-rnnlm-librispeech", 
                                           savedir="pretrained_models/asr-crdnn-rnnlm-librispeech")
print(asr_model.transcribe_file('ep1_v2.wav'))
# Redireciona a saída do print para um arquivo de texto
# with open("saida.txt", "w") as arquivo_saida:
#     sys.stdout = arquivo_saida  # Redireciona a saída

#     # Executa a transcrição e imprime o resultado
#     #resultado = asr_model.transcribe_file('exemplo_convertido.wav')
#     resultado = asr_model.transcribe_file('ep1_v.wav')
#     print(resultado)

# # Restaura a saída padrão
#sys.stdout = sys.__stdout__

tempo_decorrido = time.time() - inicio
print(f"Tempo decorrido: {tempo_decorrido} segundos")

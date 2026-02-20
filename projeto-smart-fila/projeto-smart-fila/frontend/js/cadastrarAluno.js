form.addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.querySelector('#alunoId').value;
    // Se tiver ID, a lógica de edição assume em outro arquivo ou via condição
    if (id) return; 

    const aluno = {
        nome: document.querySelector('#nome').value,
        turma: document.querySelector('#turma').value,
        ra: document.querySelector('#ra').value
    };

    await fetch(URL_BASE, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(aluno)
    });
    
    form.reset();
    listarAlunos();
});
async function carregarParaEditar(id) {
    const res = await fetch(`${URL_BASE}/${id}`);
    const a = await res.json();
    
    document.querySelector('#alunoId').value = a.id;
    document.querySelector('#nome').value = a.nome;
    document.querySelector('#turma').value = a.turma;
    document.querySelector('#ra').value = a.ra;
    document.querySelector('#btnSalvar').innerText = "Atualizar";
}

// Lógica de envio do PUT (Intercepta o form se houver ID)
form.addEventListener('submit', async (e) => {
    const id = document.querySelector('#alunoId').value;
    if (!id) return;

    e.preventDefault();
    const aluno = {
        nome: document.querySelector('#nome').value,
        turma: document.querySelector('#turma').value,
        ra: document.querySelector('#ra').value
    };

    await fetch(`${URL_BASE}/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(aluno)
    });

    document.querySelector('#alunoId').value = '';
    document.querySelector('#btnSalvar').innerText = "Salvar";
    form.reset();
    listarAlunos();
});
async function executarExclusao(id) {
    if (confirm("Deseja excluir este aluno?")) {
        await fetch(`${URL_BASE}/${id}`, { method: 'DELETE' });
        listarAlunos();
    }
}